// $ANTLR 3.4 /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g 2012-02-02 22:20:09

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class AbschlussaufgabeParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ESC_SEQ", "ID", "INT", "STRING", "WS", "'('", "')'", "'++'", "':='", "';'", "'print'"
    };

    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int COMMENT=4;
    public static final int ESC_SEQ=5;
    public static final int ID=6;
    public static final int INT=7;
    public static final int STRING=8;
    public static final int WS=9;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public AbschlussaufgabeParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AbschlussaufgabeParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AbschlussaufgabeParser.tokenNames; }
    public String getGrammarFileName() { return "/home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g"; }


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "program"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:8:1: program : ( statement )* EOF ;
    public final AbschlussaufgabeParser.program_return program() throws RecognitionException {
        AbschlussaufgabeParser.program_return retval = new AbschlussaufgabeParser.program_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF2=null;
        AbschlussaufgabeParser.statement_return statement1 =null;


        CommonTree EOF2_tree=null;

        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:8:9: ( ( statement )* EOF )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:8:11: ( statement )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:8:11: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:8:11: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program31);
            	    statement1=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_program34); 
            EOF2_tree = 
            (CommonTree)adaptor.create(EOF2)
            ;
            adaptor.addChild(root_0, EOF2_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "program"


    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:11:1: statement : ( variable_declaration | print ) ';' !;
    public final AbschlussaufgabeParser.statement_return statement() throws RecognitionException {
        AbschlussaufgabeParser.statement_return retval = new AbschlussaufgabeParser.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal5=null;
        AbschlussaufgabeParser.variable_declaration_return variable_declaration3 =null;

        AbschlussaufgabeParser.print_return print4 =null;


        CommonTree char_literal5_tree=null;

        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:12:2: ( ( variable_declaration | print ) ';' !)
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:12:4: ( variable_declaration | print ) ';' !
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:12:4: ( variable_declaration | print )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:12:5: variable_declaration
                    {
                    pushFollow(FOLLOW_variable_declaration_in_statement46);
                    variable_declaration3=variable_declaration();

                    state._fsp--;

                    adaptor.addChild(root_0, variable_declaration3.getTree());

                    }
                    break;
                case 2 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:12:28: print
                    {
                    pushFollow(FOLLOW_print_in_statement50);
                    print4=print();

                    state._fsp--;

                    adaptor.addChild(root_0, print4.getTree());

                    }
                    break;

            }


            char_literal5=(Token)match(input,14,FOLLOW_14_in_statement53); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "print"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:15:1: print : 'print' ^ expression ;
    public final AbschlussaufgabeParser.print_return print() throws RecognitionException {
        AbschlussaufgabeParser.print_return retval = new AbschlussaufgabeParser.print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal6=null;
        AbschlussaufgabeParser.expression_return expression7 =null;


        CommonTree string_literal6_tree=null;

        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:15:7: ( 'print' ^ expression )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:15:9: 'print' ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            string_literal6=(Token)match(input,15,FOLLOW_15_in_print64); 
            string_literal6_tree = 
            (CommonTree)adaptor.create(string_literal6)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal6_tree, root_0);


            pushFollow(FOLLOW_expression_in_print67);
            expression7=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression7.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "print"


    public static class variable_declaration_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variable_declaration"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:18:1: variable_declaration : ID ':=' ^ expression ;
    public final AbschlussaufgabeParser.variable_declaration_return variable_declaration() throws RecognitionException {
        AbschlussaufgabeParser.variable_declaration_return retval = new AbschlussaufgabeParser.variable_declaration_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID8=null;
        Token string_literal9=null;
        AbschlussaufgabeParser.expression_return expression10 =null;


        CommonTree ID8_tree=null;
        CommonTree string_literal9_tree=null;

        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:19:2: ( ID ':=' ^ expression )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:19:4: ID ':=' ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            ID8=(Token)match(input,ID,FOLLOW_ID_in_variable_declaration78); 
            ID8_tree = 
            (CommonTree)adaptor.create(ID8)
            ;
            adaptor.addChild(root_0, ID8_tree);


            string_literal9=(Token)match(input,13,FOLLOW_13_in_variable_declaration80); 
            string_literal9_tree = 
            (CommonTree)adaptor.create(string_literal9)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal9_tree, root_0);


            pushFollow(FOLLOW_expression_in_variable_declaration83);
            expression10=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression10.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variable_declaration"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:22:1: expression : string_concat ;
    public final AbschlussaufgabeParser.expression_return expression() throws RecognitionException {
        AbschlussaufgabeParser.expression_return retval = new AbschlussaufgabeParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        AbschlussaufgabeParser.string_concat_return string_concat11 =null;



        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:23:2: ( string_concat )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:23:4: string_concat
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_string_concat_in_expression94);
            string_concat11=string_concat();

            state._fsp--;

            adaptor.addChild(root_0, string_concat11.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class string_concat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "string_concat"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:26:1: string_concat : parenthesized_expression ( '++' ^ parenthesized_expression )* ;
    public final AbschlussaufgabeParser.string_concat_return string_concat() throws RecognitionException {
        AbschlussaufgabeParser.string_concat_return retval = new AbschlussaufgabeParser.string_concat_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal13=null;
        AbschlussaufgabeParser.parenthesized_expression_return parenthesized_expression12 =null;

        AbschlussaufgabeParser.parenthesized_expression_return parenthesized_expression14 =null;


        CommonTree string_literal13_tree=null;

        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:27:2: ( parenthesized_expression ( '++' ^ parenthesized_expression )* )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:27:4: parenthesized_expression ( '++' ^ parenthesized_expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_parenthesized_expression_in_string_concat105);
            parenthesized_expression12=parenthesized_expression();

            state._fsp--;

            adaptor.addChild(root_0, parenthesized_expression12.getTree());

            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:27:29: ( '++' ^ parenthesized_expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:27:30: '++' ^ parenthesized_expression
            	    {
            	    string_literal13=(Token)match(input,12,FOLLOW_12_in_string_concat108); 
            	    string_literal13_tree = 
            	    (CommonTree)adaptor.create(string_literal13)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(string_literal13_tree, root_0);


            	    pushFollow(FOLLOW_parenthesized_expression_in_string_concat111);
            	    parenthesized_expression14=parenthesized_expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, parenthesized_expression14.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "string_concat"


    public static class parenthesized_expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parenthesized_expression"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:30:1: parenthesized_expression : ( ID | literal | '(' ! expression ')' !);
    public final AbschlussaufgabeParser.parenthesized_expression_return parenthesized_expression() throws RecognitionException {
        AbschlussaufgabeParser.parenthesized_expression_return retval = new AbschlussaufgabeParser.parenthesized_expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID15=null;
        Token char_literal17=null;
        Token char_literal19=null;
        AbschlussaufgabeParser.literal_return literal16 =null;

        AbschlussaufgabeParser.expression_return expression18 =null;


        CommonTree ID15_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree char_literal19_tree=null;

        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:31:2: ( ID | literal | '(' ! expression ')' !)
            int alt4=3;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt4=1;
                }
                break;
            case INT:
            case STRING:
                {
                alt4=2;
                }
                break;
            case 10:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:31:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    ID15=(Token)match(input,ID,FOLLOW_ID_in_parenthesized_expression124); 
                    ID15_tree = 
                    (CommonTree)adaptor.create(ID15)
                    ;
                    adaptor.addChild(root_0, ID15_tree);


                    }
                    break;
                case 2 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:32:4: literal
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_literal_in_parenthesized_expression129);
                    literal16=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, literal16.getTree());

                    }
                    break;
                case 3 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:33:4: '(' ! expression ')' !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal17=(Token)match(input,10,FOLLOW_10_in_parenthesized_expression134); 

                    pushFollow(FOLLOW_expression_in_parenthesized_expression137);
                    expression18=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression18.getTree());

                    char_literal19=(Token)match(input,11,FOLLOW_11_in_parenthesized_expression139); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parenthesized_expression"


    public static class literal_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:36:1: literal : ( INT | STRING );
    public final AbschlussaufgabeParser.literal_return literal() throws RecognitionException {
        AbschlussaufgabeParser.literal_return retval = new AbschlussaufgabeParser.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set20=null;

        CommonTree set20_tree=null;

        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:36:9: ( INT | STRING )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set20=(Token)input.LT(1);

            if ( (input.LA(1) >= INT && input.LA(1) <= STRING) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set20)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_program31 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_EOF_in_program34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_declaration_in_statement46 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_print_in_statement50 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_statement53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_print64 = new BitSet(new long[]{0x00000000000005C0L});
    public static final BitSet FOLLOW_expression_in_print67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_variable_declaration78 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_variable_declaration80 = new BitSet(new long[]{0x00000000000005C0L});
    public static final BitSet FOLLOW_expression_in_variable_declaration83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_concat_in_expression94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parenthesized_expression_in_string_concat105 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_string_concat108 = new BitSet(new long[]{0x00000000000005C0L});
    public static final BitSet FOLLOW_parenthesized_expression_in_string_concat111 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ID_in_parenthesized_expression124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_parenthesized_expression129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_parenthesized_expression134 = new BitSet(new long[]{0x00000000000005C0L});
    public static final BitSet FOLLOW_expression_in_parenthesized_expression137 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_parenthesized_expression139 = new BitSet(new long[]{0x0000000000000002L});

}