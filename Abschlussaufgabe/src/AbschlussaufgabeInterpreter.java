// $ANTLR 3.4 /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g 2012-02-02 22:39:45

import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AbschlussaufgabeInterpreter extends TreeParser {
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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public AbschlussaufgabeInterpreter(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AbschlussaufgabeInterpreter(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return AbschlussaufgabeInterpreter.tokenNames; }
    public String getGrammarFileName() { return "/home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g"; }


    HashMap<String, Value> vars = new HashMap<String, Value>();



    // $ANTLR start "program"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:16:1: program : ( statement )* ;
    public final void program() throws RecognitionException {
        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:16:9: ( ( statement )* )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:16:11: ( statement )*
            {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:16:11: ( statement )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:16:11: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program45);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "statement"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:19:1: statement : ( ^( ':=' ID expression ) | ^( 'print' expression ) );
    public final void statement() throws RecognitionException {
        CommonTree ID1=null;
        Value expression2 =null;

        Value expression3 =null;


        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:20:2: ( ^( ':=' ID expression ) | ^( 'print' expression ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
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
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:20:4: ^( ':=' ID expression )
                    {
                    match(input,13,FOLLOW_13_in_statement58); 

                    match(input, Token.DOWN, null); 
                    ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_statement60); 

                    pushFollow(FOLLOW_expression_in_statement62);
                    expression2=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    vars.put((ID1!=null?ID1.getText():null), expression2);

                    }
                    break;
                case 2 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:21:8: ^( 'print' expression )
                    {
                    match(input,15,FOLLOW_15_in_statement76); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_statement78);
                    expression3=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    System.out.print(expression3);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "expression"
    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:24:1: expression returns [ Value result ] : ( ^( '++' v1= expression v2= expression ) | ID | STRING | INT );
    public final Value expression() throws RecognitionException {
        Value result = null;


        CommonTree ID4=null;
        CommonTree STRING5=null;
        CommonTree INT6=null;
        Value v1 =null;

        Value v2 =null;


        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:25:2: ( ^( '++' v1= expression v2= expression ) | ID | STRING | INT )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case ID:
                {
                alt3=2;
                }
                break;
            case STRING:
                {
                alt3=3;
                }
                break;
            case INT:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:25:4: ^( '++' v1= expression v2= expression )
                    {
                    match(input,12,FOLLOW_12_in_expression97); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression101);
                    v1=expression();

                    state._fsp--;


                    pushFollow(FOLLOW_expression_in_expression105);
                    v2=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    result = v1.evaluate("++", v2);

                    }
                    break;
                case 2 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:26:4: ID
                    {
                    ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_expression113); 

                    result = vars.get((ID4!=null?ID4.getText():null));

                    }
                    break;
                case 3 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:27:4: STRING
                    {
                    STRING5=(CommonTree)match(input,STRING,FOLLOW_STRING_in_expression120); 

                    result = StringValue.parseRaw((STRING5!=null?STRING5.getText():null));

                    }
                    break;
                case 4 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/AbschlussaufgabeInterpreter.g:28:4: INT
                    {
                    INT6=(CommonTree)match(input,INT,FOLLOW_INT_in_expression127); 

                    result = IntegerValue.parseRaw((INT6!=null?INT6.getText():null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "expression"

    // Delegated rules


 

    public static final BitSet FOLLOW_statement_in_program45 = new BitSet(new long[]{0x000000000000A002L});
    public static final BitSet FOLLOW_13_in_statement58 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_statement60 = new BitSet(new long[]{0x00000000000011C0L});
    public static final BitSet FOLLOW_expression_in_statement62 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_15_in_statement76 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_statement78 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_12_in_expression97 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression101 = new BitSet(new long[]{0x00000000000011C0L});
    public static final BitSet FOLLOW_expression_in_expression105 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_expression113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expression120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_expression127 = new BitSet(new long[]{0x0000000000000002L});

}