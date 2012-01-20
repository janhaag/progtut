import java.util.List;

public interface FancyList<A> extends List<A> {
    /**
     * Right-fold this FancyList.
     */
    public <B> B foldr(Function2<A, B, B> f, B elem);

    /**
     * Left-Folf this FancyList
     */
    public <B> B foldl(Function2<B, A, B> f, B elem);

    /**
     * Map a Function over this FancyList
     */
    public <B> FancyList<B> map(Function1<A, B> f);

    /**
     * Filter this FancyList by a predicate
     */
    public FancyList<A> filter(Function1<A, Boolean> p);
}
