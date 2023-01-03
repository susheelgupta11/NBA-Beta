package org.nba.application

class FormCategory {

	Category category
	
    static constraints = {
    }
	
	public enum Category {
		Form_1('Form 1'),Form_2('Form_2'),Form_3('Form_3'),Form_4('Form_3'),Form_B('Form B'),Form_C('Form C')
	
		final String value
	
		private Category(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}
