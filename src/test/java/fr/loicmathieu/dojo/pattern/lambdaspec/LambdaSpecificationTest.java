package fr.loicmathieu.dojo.pattern.lambdaspec;

import org.junit.Assert;
import org.junit.Test;

import fr.loicmathieu.dojo.pattern.lambdaspec.spec.ComplexSpecification;
import fr.loicmathieu.dojo.pattern.specification.SpecificationTest.Obj1;


public class LambdaSpecificationTest {

	@Test
	public void testAndWithSuccessfullSpec() {
		//given
		Obj1 obj1 = new Obj1();
		obj1.setText("text");
		obj1.setNb(11);
		LeafSpecification<Obj1> spec1 = LeafSpecification.from(obj -> obj.getText() != null);
		LeafSpecification<Obj1> spec2 = LeafSpecification.from(obj -> obj.getNb() > 10);
		LeafSpecification<Obj1> spec3 = LeafSpecification.from(obj -> obj.getNb() < 1);
		//when
		boolean isSatisfied = spec1.and(spec2.or(spec3)).isSatisfiedBy(obj1);

		//then
		Assert.assertTrue(isSatisfied);
	}

	@Test
	public void testMixLambdaAndClassic() {
		//given
		Obj1 obj1 = new Obj1();
		obj1.setText("text");
		obj1.setNb(11);
		LeafSpecification<Obj1> spec1 = new ComplexSpecification();
		LeafSpecification<Obj1> spec2 = LeafSpecification.from(obj -> obj.getNb() > 10);
		LeafSpecification<Obj1> spec3 = LeafSpecification.from(obj -> obj.getNb() < 1);
		//when
		boolean isSatisfied = spec1.and(spec2.or(spec3)).isSatisfiedBy(obj1);

		//then
		Assert.assertTrue(isSatisfied);
	}

	@Test
	public void testAndWithUnsuccessfullSpec() {
		//given
		Obj1 obj1 = new Obj1();
		obj1.setText("text");
		obj1.setNb(9);
		LeafSpecification<Obj1> spec1 = LeafSpecification.from(obj -> obj.getText() != null);
		LeafSpecification<Obj1> spec2 = LeafSpecification.from(obj -> obj.getNb() > 10);
		LeafSpecification<Obj1> spec3 = LeafSpecification.from(obj -> obj.getNb() < 1);

		//when
		boolean isSatisfied = spec1.and(spec2.or(spec3)).isSatisfiedBy(obj1);

		//then
		Assert.assertFalse(isSatisfied);
	}
}
