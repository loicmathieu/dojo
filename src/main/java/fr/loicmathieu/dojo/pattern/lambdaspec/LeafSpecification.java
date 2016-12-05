package fr.loicmathieu.dojo.pattern.lambdaspec;


/**
 * LeafSpecification : this is the class that user needs to extends to implements their specification.
 * It also contains a static factory method to easily create Specification object from a lambda.
 *
 * @author lmathieu
 *
 * @param <T> The objet type of the specification
 */
public abstract class LeafSpecification<T> extends AbstractCompositeSpecification<T>{

	public static <T> LeafSpecification<T> from(Specification<T> spec){
		return new LambdaSpecification<>(spec);
	}

	static class LambdaSpecification<T> extends LeafSpecification<T> {
		private Specification<T> s;

		LambdaSpecification(Specification<T> s){
			this.s = s;
		}

		@Override
		public boolean isSatisfiedBy(T obj) {
			return s.isSatisfiedBy(obj);
		}

	}
}
