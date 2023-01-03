package org.nba.versions

import org.nba.application.FormCategory.Category;

class VersionFormCategory {

	Category category
	static constraints = {
	}
	public enum Category {
		Form_1('Form 1'),Form_2('Form 2'),Form_3('Form 3'),Form_4('Form 4'),Form_B('Form B'),Form_C('Form C')
	
		final String value
	
		private Category(String value) {
			this.value = value
		}
	
		String toString() {
			value
		}
	}
}
