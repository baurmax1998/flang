grammar Alt;


sourceElement
    : statement
    ;

statement
    : block
    | variableStatement
    | emptyStatement
    | expressionStatement
    | ifStatement
    | iterationStatement
    | returnStatement
    | labelledStatement
    | debuggerStatement
    | functionDeclaration
    ;

block
    : '{' statementList? '}'
    ;

statementList
    : statement+
    ;

variableStatement
    : varModifier variableDeclarationList eos
    ;

variableDeclarationList
    : variableDeclaration (',' variableDeclaration)*
    ;

variableDeclaration
    : (Identifier | arrayLiteral | objectLiteral) ('=' singleExpression)? // ECMAScript 6: Array & Object Matching
    ;

emptyStatement
    : SemiColon
    ;

expressionStatement
    : expressionSequence eos
    ;

ifStatement
    : If '(' expressionSequence ')' statement (Else statement)?
    ;


iterationStatement
    : While '(' expressionSequence ')' statement                                         # WhileStatement
    ;

varModifier
    : Var
    ;

returnStatement
    : Return eos
    ;

labelledStatement
    : Identifier ':' statement
    ;


debuggerStatement
    : Debugger eos
    ;

functionDeclaration
    : Function Identifier '(' formalParameterList? ')' '{' functionBody '}'
    ;




formalParameterList
    : formalParameterArg (',' formalParameterArg)* (',' lastFormalParameterArg)?
    | lastFormalParameterArg
    | arrayLiteral                            // ECMAScript 6: Parameter Context Matching
    | objectLiteral                           // ECMAScript 6: Parameter Context Matching
    ;

formalParameterArg
    : Identifier ('=' singleExpression)?      // ECMAScript 6: Initialization
    ;

lastFormalParameterArg                        // ECMAScript 6: Rest Parameter
    : Ellipsis Identifier
    ;

functionBody
    : sourceElements?
    ;

sourceElements
    : sourceElement+
    ;

arrayLiteral
    : '[' ','* elementList? ','* ']'
    ;

elementList
    : singleExpression (','+ singleExpression)* (','+ lastElement)?
    | lastElement
    ;

lastElement                      // ECMAScript 6: Spread Operator
    : Ellipsis Identifier
    ;

objectLiteral
    : '{' (propertyAssignment (',' propertyAssignment)*)? ','? '}'
    ;

propertyAssignment
    : propertyName (':' |'=') singleExpression       # PropertyExpressionAssignment
    | '[' singleExpression ']' ':' singleExpression  # ComputedPropertyExpressionAssignment
    | Identifier                                     # PropertyShorthand
    ;

propertyName
    : identifierName
    | StringLiteral
    | numericLiteral
    ;

arguments
    : '('(
          singleExpression (',' singleExpression)* (',' lastArgument)? |
          lastArgument
       )?')'
    ;

lastArgument                                  // ECMAScript 6: Spread Operator
    : Ellipsis Identifier
    ;

expressionSequence
    : singleExpression (',' singleExpression)*
    ;

singleExpression
    : Function Identifier? '(' formalParameterList? ')' '{' functionBody '}' # FunctionExpression
    | singleExpression '[' expressionSequence ']'                            # MemberIndexExpression
    | singleExpression '.' identifierName                                    # MemberDotExpression
    | singleExpression arguments                                             # ArgumentsExpression
    | '+' singleExpression                                                   # UnaryPlusExpression
    | '-' singleExpression                                                   # UnaryMinusExpression
    | '!' singleExpression                                                   # NotExpression
    | singleExpression ('*' | '/' | '%') singleExpression                    # MultiplicativeExpression
    | singleExpression ('+' | '-') singleExpression                          # AdditiveExpression
    | singleExpression ('<' | '>' | '<=' | '>=') singleExpression            # RelationalExpression
    | singleExpression ('==' | '!=') singleExpression                        # EqualityExpression
    | singleExpression '&&' singleExpression                                 # LogicalAndExpression
    | singleExpression '||' singleExpression                                 # LogicalOrExpression
    | singleExpression '?' singleExpression ':' singleExpression             # TernaryExpression
    | singleExpression '=' singleExpression                                  # AssignmentExpression
    | singleExpression TemplateStringLiteral                                 # TemplateStringExpression  // ECMAScript 6
    | This                                                                   # ThisExpression
    | Identifier                                                             # IdentifierExpression
    | literal                                                                # LiteralExpression
    | arrayLiteral                                                           # ArrayLiteralExpression
    | objectLiteral                                                          # ObjectLiteralExpression
    | '(' expressionSequence ')'                                             # ParenthesizedExpression
    ;


literal
    : NullLiteral
    | BooleanLiteral
    | StringLiteral
    | TemplateStringLiteral
    | numericLiteral
    ;

numericLiteral
    : DecimalLiteral
    ;

identifierName
    : Identifier
    | reservedWord
    ;

Identifier
    : ('A'..'Z' | 'a'..'z' | ' ')+ ;


reservedWord
    : keyword
    | NullLiteral
    | BooleanLiteral
    ;

keyword
    : Else
    | Var
    | While
    | Debugger
    | Return
    | Function
    | This
    | If
    ;


eos
    : SemiColon
    | EOF
    ;



OpenBracket:                    '[';
CloseBracket:                   ']';
OpenParen:                      '(';
CloseParen:                     ')';
OpenBrace:                      '{';
CloseBrace:                     '}';
SemiColon:                      ';';
Comma:                          ',';
Assign:                         '=';
QuestionMark:                   '?';
Colon:                          ':';
Ellipsis:                       '...';
Dot:                            '.';
Plus:                           '+';
Minus:                          '-';
Not:                            '!';
Multiply:                       '*';
Divide:                         '/';
Modulus:                        '%';
LessThan:                       '<';
MoreThan:                       '>';
LessThanEquals:                 '<=';
GreaterThanEquals:              '>=';
Equals_:                        '==';
NotEquals:                      '!=';
And:                            '&&';
Or:                             '||';

/// Null Literals

NullLiteral:                    'null';

/// Boolean Literals

BooleanLiteral:                 'true'
              |                 'false';

/// Numeric Literals

DecimalLiteral:                 DecimalIntegerLiteral '.' [0-9]*
              |                 '.' [0-9]+
              |                 DecimalIntegerLiteral
              ;


/// Keywords

Break:                          'break';
Do:                             'do';
Else:                           'else';
Var:                            'var';
Catch:                          'catch';
Return:                         'return';
Continue:                       'continue';
For:                            'for';
While:                          'while';
Debugger:                       'debugger';
Function:                       'function';
This:                           'this';
If:                             'if';

/// Future Reserved Words

Import:                         'import';

/// The following tokens are also considered to be FutureReservedWords
/// when parsing strict mode

Package:                        'package' ;



/// String Literals
StringLiteral
          : ('"' DoubleStringCharacter* '"')
          ;

TemplateStringLiteral:          '`' ('\\`' | ~'`')* '`';

WhiteSpaces:                    [\t\u000B\u000C\u0020\u00A0]+ -> channel(HIDDEN);

LineTerminator:                 [\r\n\u2028\u2029] -> channel(HIDDEN);

// Fragment rules

fragment DoubleStringCharacter
    : ~["\\\r\n]
    | '\\' EscapeSequence
    | LineContinuation
    ;
fragment EscapeSequence
    : CharacterEscapeSequence
    | '0' // no digit ahead! TODO
    ;
fragment CharacterEscapeSequence
    : SingleEscapeCharacter
    | NonEscapeCharacter
    ;
fragment SingleEscapeCharacter
    : ['"\\bfnrtv]
    ;

fragment NonEscapeCharacter
    : ~['"\\bfnrtv0-9xu\r\n]
    ;
fragment EscapeCharacter
    : SingleEscapeCharacter
    | [0-9]
    | [xu]
    ;
fragment LineContinuation
    : '\\' [\r\n\u2028\u2029]
    ;
fragment DecimalIntegerLiteral
    : '0'
    | [1-9] [0-9]*
    ;

