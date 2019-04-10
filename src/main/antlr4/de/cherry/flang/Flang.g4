grammar Flang;

program
  : statement* EOF
  ;


statement
  : functionDef
 	| variableDef
 	| ifBlock
 	| whileBlock
 	| returnStatement
 	| assign
 	| callAccess
 	| block
 	;

block
  : OpenBrace statement* CloseBrace
  ;

functionDef
  : Func Identifier OpenParen expressionSequence CloseParen (statement)
  ;

variableDef
  : Var Identifier Assign singleExpression
  ;

assign
  : Identifier Assign singleExpression
  ;

callAccess
  : Identifier OpenParen expressionSequence CloseParen
  ;

ifBlock
  : If OpenParen expressionSequence  CloseParen statement (Else statement)?
  ;

whileBlock
  : While OpenParen expressionSequence CloseParen statement
  ;

returnStatement
  : Return
  ;

expressionSequence
    : singleExpression (Comma singleExpression)*
    ;

singleExpression
    : '!' singleExpression                                                   # NotExpression
    | singleExpression (Multiply | Divide | Modulus) singleExpression                    # MultiplicativeExpression
    | singleExpression (Plus | Minus) singleExpression                          # AdditiveExpression
    | singleExpression (LessThan | MoreThan | LessThanEquals | GreaterThanEquals) singleExpression            # RelationalExpression
    | singleExpression (Equals_ | NotEquals) singleExpression                        # EqualityExpression
    | singleExpression And singleExpression                                 # LogicalAndExpression
    | singleExpression Or singleExpression                                 # LogicalOrExpression
    | String                                                                 # StringExpression
    | Int                                                                    # IntExpression
    | Bool                                                                   # BoolExpression
    | This                                                                   # ThisExpression
    | Identifier                                                             # IdentifierExpression
    | OpenParen expressionSequence CloseParen                                # ParenthesizedExpression
    ;

This: 'this';
Var: 'var';
Func: 'func';
While: 'while';
Return: 'return';
If: 'if';
Else: 'else';




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

Identifier:('A'..'Z' | 'a'..'z' | ' ')+ ;
String: '"' ('A'..'Z' | 'a'..'z' | ' ')+ '"' ;
Int: ('0'..'9')+;
Bool: ('true'|'false');

WS : [ \t\r\n]+ -> skip ;

