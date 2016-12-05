package fr.loicmathieu.dojo.pattern.lambdaspec;


public class LambdaSpecificationFactory<T> {
	public LeafSpecification<T> from(Specification<T> s){
		return new LambdaSpecification<>(s);
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
