package fr.loicmathieu.dojo.pattern.lambdaspec;

import org.junit.Assert;
import org.junit.Test;

import fr.loicmathieu.dojo.pattern.lambdaspec.spec.Obj1HasNotNullText;
import fr.loicmathieu.dojo.pattern.lambdaspec.spec.Obj1NbLessThan1;
import fr.loicmathieu.dojo.pattern.lambdaspec.spec.Obj1NbMoreThan10;

public class SpecificationTest {

	@Test
	public void testAndWithSuccessfullSpec() {
		//given
		Obj1 obj1 = new Obj1();
		obj1.setText("text");
		obj1.setNb(11);
		Obj1HasNotNullText spec1 = new Obj1HasNotNullText();
		Obj1NbMoreThan10 spec2 = new Obj1NbMoreThan10();
		Obj1NbLessThan1 spec3 = new Obj1NbLessThan1();

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
		Obj1HasNotNullText spec1 = new Obj1HasNotNullText();
		Obj1NbMoreThan10 spec2 = new Obj1NbMoreThan10();
		Obj1NbLessThan1 spec3 = new Obj1NbLessThan1();

		//when
		boolean isSatisfied = spec1.and(spec2.or(spec3)).isSatisfiedBy(obj1);

		//then
		Assert.assertFalse(isSatisfied);
	}


	public static class Obj1  {
		private String text;
		private int nb;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getNb() {
			return nb;
		}

		public void setNb(int nb) {
			this.nb = nb;
		}

	}

}
