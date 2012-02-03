public class StringValue implements Value {
    private final String v;

    public static StringValue parseRaw(String rawString) {
        StringBuilder b = new StringBuilder();
        boolean escape = false;
        for (int i = 1; i < rawString.length() - 1; i++) {
            char c = rawString.charAt(i);
            switch (c) {
                case '\\':
                    if (escape) {
                        b.append('\\');
                        escape = false;
                    }
                    else escape = true;
                    break;
                case 'n':
                    if (escape) {
                        b.append('\n');
                        escape = false;
                    } else b.append('n');
                    break;
                case '"':
                    escape = false;
                    b.append('"');
                    break;
                default:
                    b.append(c);
            }
        }
        return new StringValue(b.toString());
    }

    public StringValue(String v) {
        this.v = v;
    }

    public String toString() {
        return v;
    }

    public Value evaluate(OpConcat op, Value v) {
        return new StringValue(toString() + v.toString());
    }
}
