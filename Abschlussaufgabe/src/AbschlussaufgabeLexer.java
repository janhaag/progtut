// $ANTLR 3.4 /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g 2012-02-02 22:20:09

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class AbschlussaufgabeLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public AbschlussaufgabeLexer() {} 
    public AbschlussaufgabeLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AbschlussaufgabeLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:2:7: ( '(' )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:2:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:3:7: ( ')' )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:3:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:4:7: ( '++' )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:4:9: '++'
            {
            match("++"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:5:7: ( ':=' )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:5:9: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:6:7: ( ';' )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:6:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:7:7: ( 'print' )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:7:9: 'print'
            {
            match("print"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:40:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:40:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:40:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:43:5: ( ( '0' .. '9' )+ )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:43:7: ( '0' .. '9' )+
            {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:43:7: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:47:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='/') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='/') ) {
                    alt6=1;
                }
                else if ( (LA6_1=='*') ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:47:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
                    {
                    match("//"); 



                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:47:14: (~ ( '\\n' | '\\r' ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:47:28: ( '\\r' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\r') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:47:28: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    skip();

                    }
                    break;
                case 2 :
                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:48:9: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 



                    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:48:14: ( options {greedy=false; } : . )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='*') ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1=='/') ) {
                                alt5=2;
                            }
                            else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
                                alt5=1;
                            }


                        }
                        else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:48:42: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    match("*/"); 



                    skip();

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:51:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:51:9: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:59:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:59:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:59:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\\') ) {
                    alt7=1;
                }
                else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:59:14: ESC_SEQ
            	    {
            	    mESC_SEQ(); 


            	    }
            	    break;
            	case 2 :
            	    // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:59:24: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:65:5: ( '\\\\' ( 'n' | '\\\"' | '\\\\' ) )
            // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:65:9: '\\\\' ( 'n' | '\\\"' | '\\\\' )
            {
            match('\\'); 

            if ( input.LA(1)=='\"'||input.LA(1)=='\\'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    public void mTokens() throws RecognitionException {
        // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | ID | INT | COMMENT | WS | STRING )
        int alt8=11;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt8=1;
            }
            break;
        case ')':
            {
            alt8=2;
            }
            break;
        case '+':
            {
            alt8=3;
            }
            break;
        case ':':
            {
            alt8=4;
            }
            break;
        case ';':
            {
            alt8=5;
            }
            break;
        case 'p':
            {
            int LA8_6 = input.LA(2);

            if ( (LA8_6=='r') ) {
                int LA8_12 = input.LA(3);

                if ( (LA8_12=='i') ) {
                    int LA8_13 = input.LA(4);

                    if ( (LA8_13=='n') ) {
                        int LA8_14 = input.LA(5);

                        if ( (LA8_14=='t') ) {
                            int LA8_15 = input.LA(6);

                            if ( ((LA8_15 >= '0' && LA8_15 <= '9')||(LA8_15 >= 'A' && LA8_15 <= 'Z')||LA8_15=='_'||(LA8_15 >= 'a' && LA8_15 <= 'z')) ) {
                                alt8=7;
                            }
                            else {
                                alt8=6;
                            }
                        }
                        else {
                            alt8=7;
                        }
                    }
                    else {
                        alt8=7;
                    }
                }
                else {
                    alt8=7;
                }
            }
            else {
                alt8=7;
            }
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt8=7;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt8=8;
            }
            break;
        case '/':
            {
            alt8=9;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt8=10;
            }
            break;
        case '\"':
            {
            alt8=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 8, 0, input);

            throw nvae;

        }

        switch (alt8) {
            case 1 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:10: T__10
                {
                mT__10(); 


                }
                break;
            case 2 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:16: T__11
                {
                mT__11(); 


                }
                break;
            case 3 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:22: T__12
                {
                mT__12(); 


                }
                break;
            case 4 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:28: T__13
                {
                mT__13(); 


                }
                break;
            case 5 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:34: T__14
                {
                mT__14(); 


                }
                break;
            case 6 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:40: T__15
                {
                mT__15(); 


                }
                break;
            case 7 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:46: ID
                {
                mID(); 


                }
                break;
            case 8 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:49: INT
                {
                mINT(); 


                }
                break;
            case 9 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:53: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 10 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:61: WS
                {
                mWS(); 


                }
                break;
            case 11 :
                // /home/jan/Documents/progtut2011/Abschlussaufgabe/src/Abschlussaufgabe.g:1:64: STRING
                {
                mSTRING(); 


                }
                break;

        }

    }


 

}