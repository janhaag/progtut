tree grammar AbschlussaufgabeInterpreter;

options {
	tokenVocab = Abschlussaufgabe;
	ASTLabelType = CommonTree;
}

@header {
import java.util.HashMap;
}

@members {
HashMap<String, Value> vars = new HashMap<String, Value>();
}

program : statement*
	;

statement
	: ^(':=' ID expression) {vars.put($ID.text, $expression.result);} 
    	| ^('print' expression) {System.out.print($expression.result);}
	;

expression returns [ Value result ]
	: ^('++' v1=expression v2=expression) {$result = $v1.result.evaluate("++", $v2.result);}
	| ID {$result = vars.get($ID.text);}
	| STRING {$result = StringValue.parseRaw($STRING.text);}
	| INT {$result = IntegerValue.parseRaw($INT.text);}
	;
