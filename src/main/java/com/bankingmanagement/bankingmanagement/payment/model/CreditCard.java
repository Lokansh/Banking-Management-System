package com.bankingmanagement.bankingmanagement.payment.model;


public class CreditCard {
        private String firstName;
        private String lastName;
        private String address1;
        private String address2;
        private String city;
        private String zipCode;
        private String contactNumber;
        private String email;
        private String sin;
        private String salary;
        private String age;
    private String loanAmount;
        private String loanType;

        public CreditCard( String firstName, String lastName, String address1, String address2, String city, String zipCode, String contactNumber, String email, String sin, String salary, String age,String loanAmount, String loanType) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address1 = address1;
            this.address2 = address2;
            this.city = city;
            this.zipCode = zipCode;
            this.contactNumber = contactNumber;
            this.email = email;
            this.sin = sin;
            this.salary = salary;
            this.age = age;
            this.loanAmount=loanAmount;
            this.loanType = loanType;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSin() {
            return sin;
        }

        public void setSin(String sin) {
            this.sin = sin;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getLoanType() {
            return loanType;
        }

        public void setLoanType(String loanType) {
            this.loanType = loanType;
        }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }
}
