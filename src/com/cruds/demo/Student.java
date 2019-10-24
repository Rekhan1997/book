package com.cruds.demo;


public class Student  {
		
		private String usn;
		private String name;
		
		
		public Student(String usn, String name) {
			super();
			this.usn = usn;
			this.name = name;
		}

		public  Student() {
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUsn() {
			return usn;
		}
		public void setUsn(String usn) {
			this.usn = usn;
		}

		@Override
		public String toString() {
			return "Student [usn=" + usn + ", name=" + name + "]";
		}
		
}


