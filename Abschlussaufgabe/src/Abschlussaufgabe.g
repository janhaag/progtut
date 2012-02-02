grammar Abschlussaufgabe;

options {
	output = AST;
	ASTLabelType = CommonTree;
}

program	: statement* EOF
	;

statement
	: (variable_declaration | print) ';'!
	;

print	: 'print'^ expression
	;

variable_declaration
	: ID ':='^ expression
	;

expression
	: string_concat
	;

string_concat
	: parenthesized_expression ('++'^ parenthesized_expression)*
	;

parenthesized_expression
	: ID
	| literal
	| '('! expression ')'!
	;

literal	: INT
	| STRING
	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {skip();}
    |   '/*' ( options {greedy=false;} : . )* '*/' {skip();}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
ESC_SEQ
    :   '\\' ('n'|'\"'|'\\')
    ;