package fr.loicmathieu.dojo.pattern.lambdaspec;

/**
 * {@link OrSpecification} provide an Or composition for {@link Specification}.
 *
 * @author 396056
 * @author lmathieu
 *
 * @param <T> The objet type of the specification
 */
public class OrSpecification<T> extends AbstractCompositeSpecification<T>{

	/**
	 *
	 * @param specifications
	 */
	@SafeVarargs
	public OrSpecification(Specification<T>... specifications){
		super(specifications);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public boolean isSatisfiedBy(T obj) {
		boolean result=false;
		for(Specification<T> spec : specifications){
			result |= spec.isSatisfiedBy(obj);
		}
		return result;
	}



}
