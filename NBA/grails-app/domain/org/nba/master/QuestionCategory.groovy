package org.nba.master

class QuestionCategory {


	Category category

	public enum Category {
		Form_1('Form 1'),Form_2('Form 2'),Form_3('Form 3'),Form_4('Form 4')

		final String value

		private Category(String value) {
			this.value = value
		}

		String toString() {
			value
		}
	}
	static constraints = {
	}
}