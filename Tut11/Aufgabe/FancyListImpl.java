import java.util.ArrayList;

public class FancyListImpl<A> extends ArrayList<A> implements FancyList<A> {
    public static final long serialVersionUID = 0L;

    /**
     * {@inheritDoc}
     * @see FancyList#foldr(Function2<A,B,B>,B)
     */
    public <B> B foldr(Function2<A,B,B> f, B elem) {
        for (int i = size() - 1; i >= 0; i--) {
            elem = f.call(get(i), elem);
        }
        return elem;
    }

    /**
     * {@inheritDoc}
     * @see FancyList#foldl(Function2<B,A,B>,B)
     */
    public <B> B foldl(Function2<B,A,B> f, B elem) {
        for (int i = 0; i <= size() - 1; i++) {
            elem = f.call(elem, get(i));
        }
        return elem;
    }

    /**
     * {@inheritDoc}
     * @see FancyList#map(Function1<A,B>)
     */
    public <B> FancyList<B> map(final Function1<A,B> f) {
        Function2<FancyList<B>, A, FancyList<B>> transform = new Function2<FancyList<B>, A, FancyList<B>>() {
            public FancyList<B> call(FancyList<B> l, A elem) {
                l.add(f.call(elem));
                return l;
            }
        };
        return foldl(transform, new FancyListImpl<B>());
    }

    /**
     * {@inheritDoc}
     * @see FancyList#filter(Function1<A,Boolean>)
     */
    public FancyList<A> filter(final Function1<A,Boolean> p) {
        Function2<FancyList<A>, A, FancyList<A>> transform = new Function2<FancyList<A>, A, FancyList<A>>() {
            public FancyList<A> call(FancyList<A> l, A elem) {
                if (p.call(elem)) l.add(elem);
                return l;
            }
        };
        return foldl(transform, new FancyListImpl<A>());
    }
}
