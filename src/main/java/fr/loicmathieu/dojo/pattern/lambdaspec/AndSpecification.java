package fr.loicmathieu.dojo.pattern.lambdaspec;


/**
 * {@link AndSpecification} provide an And composition for {@link Specification}
 *
 * @author lmathieu
 *
 * @param <T> The objet type of the specification
 */
public  class AndSpecification<T> extends AbstractCompositeSpecification<T>{


	/**
	 * Constructor with the specifications to logically AND
	 *
	 * @param specifications
	 */
	@SafeVarargs
	public AndSpecification(Specification<T>... specifications){
		super(specifications);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public boolean isSatisfiedBy(T t) {
		boolean result=true;
		for(Specification<T> spec:specifications){
			result &=spec.isSatisfiedBy(t);
		}
		return result;
	}


}
