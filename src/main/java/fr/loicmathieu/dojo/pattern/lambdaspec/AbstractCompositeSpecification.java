package fr.loicmathieu.dojo.pattern.lambdaspec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@link AbstractCompositeSpecification} for {@link Specification} composition.
 * This class is package private, user specification needs to extends LeafSpecification.
 *
 * @author 396056
 * @author lmathieu
 *
 * @param <T> The objet type of the specification
 */
abstract class AbstractCompositeSpecification<T>  implements CompositeSpecification<T>{
	protected List<Specification<T>> specifications;

	@SafeVarargs
	protected AbstractCompositeSpecification(Specification<T>... specifications) {
		this.specifications = new ArrayList<>(Arrays.asList(specifications));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CompositeSpecification<T> and(Specification<T> other) {
		return new AndSpecification<>(this, other);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CompositeSpecification<T> or(Specification<T> other) {
		return new OrSpecification<>(this, other);

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CompositeSpecification<T> not() {
		return new NotSpecification<>(this);
	}

}
