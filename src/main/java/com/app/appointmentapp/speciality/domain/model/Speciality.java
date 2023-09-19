package com.app.appointmentapp.speciality.domain.model;
public class Speciality {
    private Long idSpeciality;
    private String name;
    private Integer grade;

    public Speciality() {
        // TODO document why this constructor is empty
    }
    public Speciality(Long idSpeciality, String name, Integer grade) {
        this.idSpeciality = idSpeciality;
        this.name = name;
        this.grade = grade;
    }

    public Long getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Long idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }


    public static final class SpecialityBuilder {
        private Long idSpeciality;
        private String name;
        private Integer grade;

        public SpecialityBuilder() {
        }

        public static SpecialityBuilder aSpeciality() {
            return new SpecialityBuilder();
        }

        public SpecialityBuilder idSpeciality(Long idSpeciality) {
            this.idSpeciality = idSpeciality;
            return this;
        }

        public SpecialityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SpecialityBuilder grade(Integer grade) {
            this.grade = grade;
            return this;
        }

        public Speciality build() {
            Speciality speciality = new Speciality();
            speciality.setIdSpeciality(idSpeciality);
            speciality.setName(name);
            speciality.setGrade(grade);
            return speciality;
        }
    }
}
