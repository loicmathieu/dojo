package fr.loicmathieu.dojo.pattern.lambdaspec;


public interface CompositeSpecification<T> extends Specification<T> {
	/**
	 * and composition
	 * @param other
	 * @return
	 */
	public CompositeSpecification<T> and(Specification<T> other);
	/**
	 * Or composition
	 * @param other
	 * @return
	 */
	public CompositeSpecification<T> or(Specification<T> other);

	/**
	 * Not composition
	 * @param other
	 * @return
	 */
	public CompositeSpecification<T> not() ;
}
