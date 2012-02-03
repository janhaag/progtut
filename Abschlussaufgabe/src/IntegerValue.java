import java.math.BigInteger;

public class IntegerValue implements Value {
    private BigInteger v;

    public static Value parseRaw(String v) {
        return new IntegerValue(new BigInteger(v));
    }

    public IntegerValue(BigInteger v) {
        this.v = v;
    }

    public Value evaluate(OpConcat op, Value v) {
        return new StringValue(toString() + v.toString());
    }

    public String toString() {
        return v.toString();
    }
}
