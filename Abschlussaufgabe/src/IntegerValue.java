import java.math.BigInteger;

public class IntegerValue implements Value {
    private BigInteger v;

    public static Value parseRaw(String v) {
        return new IntegerValue(new BigInteger(v));
    }

    public IntegerValue(BigInteger v) {
        this.v = v;
    }

    /**
     * {@inheritDoc}
     * @see Value#evaluate(String,Value)
     */
    public Value evaluate(String op, Value v) {
        switch (op) {
            case "++":
                return new StringValue(toString() + v.toString());
            default:
                throw new IllegalArgumentException(op + "is not an operator.");
        }
    }

    public String toString() {
        return v.toString();
    }
}
