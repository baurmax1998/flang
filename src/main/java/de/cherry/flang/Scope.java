package de.cherry.flang;

import java.util.HashMap;
import java.util.Map;

public class Scope {

  private Scope parent;
  private Map<String, FlangValue> variables;

  Scope() {
    // only for the global scope, the parent is null
    this(null);
  }

  Scope(Scope p) {
    parent = p;
    variables = new HashMap<>();
  }

  public void assignParam(String var, FlangValue value) {
    variables.put(var, value);
  }

  public void assign(String var, FlangValue value) {
    if(resolve(var) != null) {
      // There is already such a variable, re-assign it
      this.reAssign(var, value);
    }
    else {
      // A newly declared variable
      variables.put(var, value);
    }
  }

  private boolean isGlobalScope() {
    return parent == null;
  }

  public Scope parent() {
    return parent;
  }

  private void reAssign(String identifier, FlangValue value) {
    if(variables.containsKey(identifier)) {
      // The variable is declared in this scope
      variables.put(identifier, value);
    }
    else if(parent != null) {
      // The variable was not declared in this scope, so let
      // the parent scope re-assign it
      parent.reAssign(identifier, value);
    }
  }

  public FlangValue resolve(String var) {
    FlangValue value = variables.get(var);
    if(value != null) {
      // The variable resides in this scope
      return value;
    }
    else if(!isGlobalScope()) {
      // Let the parent scope look for the variable
      return parent.resolve(var);
    }
    else {
      // Unknown variable
      return null;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(Map.Entry<String,FlangValue> var: variables.entrySet()) {
      sb.append(var.getKey()).append("->").append(var.getValue()).append(",");
    }
    return sb.toString();
  }
}
