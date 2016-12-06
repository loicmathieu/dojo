package fr.loicmathieu.dojo.pattern.lambdaspec;

/**
 * Interface of a CompositeSpecification : it allow Specification Composition.
 *
 * In the original design of the specification pattern, these method lies on the {@link Specification} interface, but to allow usage of lambdas as
 * specification implementation the Specification interface was made a {@link FunctionlInterface} so these methods was moved in a seperate interface.
 *
 * @author lmathieu
 *
 * @param <T> The objet type of the specification
 */
public interface CompositeSpecification<T> extends Specification<T> {
	/**
	 * And composition
	 *
	 * @param other
	 * @return
	 */
	public CompositeSpecification<T> and(Specification<T> other);

	/**
	 * Or composition
	 *
	 * @param other
	 * @return
	 */
	public CompositeSpecification<T> or(Specification<T> other);


	/**
	 * Not composition
	 *
	 * @param other
	 * @return
	 */
	public CompositeSpecification<T> not() ;
}
