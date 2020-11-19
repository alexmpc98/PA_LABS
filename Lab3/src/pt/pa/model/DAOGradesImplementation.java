package pt.pa.model;

import java.util.*;

public class DAOGradesImplementation implements DAOGrades{
    private final Map<String, StudentGrade> results;

    public DAOGradesImplementation(){
        this.results = new HashMap<String, StudentGrade>();
    }

    /**
     * Gets the corresponding result for a student.
     * @param id student id to query
     * @return student grade; null if does not exist
     */
    @Override
    public StudentGrade get(String id) {
        return this.results.get(id);
    }

    /**
     * Returns a collection of all current grades.
     * @return collection of grades
     */
    @Override
    public List<StudentGrade> getAll(GradeSorting gradeSorting) {
        List<StudentGrade> list = new ArrayList<>( this.results.values() );
        gradeSorting.sort(list);
        return list;
    }

    /**
     * Adds a grade to the course results
     * @param g grade to add
     * @throws CourseGradesException if already exists a result for the student contained in <code>g</code>
     * @throws NullPointerException if <code>g</code> is null
     */
    @Override
    public void add(StudentGrade g) throws CourseGradesException, NullPointerException{
        if(g == null)
            throw new NullPointerException("StudentGrade cannot be null.");

        if(results.containsKey(g.getId()))
            throw new CourseGradesException("Student already exists.");
        results.put(g.getId(), g);
    }


    /**
     * Updates a grade within the current results.
     * @param sGrade Student Grade to be modified
     * @param grade new grade for the student
     * @return previous grade
     * @throws CourseGradesException if no student with <code>studentId</code> exist in the current results
     */
    @Override
    public int update(StudentGrade sGrade, int grade) throws CourseGradesException {
        if(grade < 0 || grade > 20) throw new CourseGradesException("Grade must be in [0,20].");
        if(!results.containsKey(sGrade.getId()))
            throw new CourseGradesException("Student does not exist: " + sGrade.getId());
        StudentGrade studentGrade = results.get(sGrade.getId());
        int oldGrade = studentGrade.updateGrade(grade);
        return oldGrade;
    }

    /**
     * Removes a grade from the course results
     * @param sGrade Student Grade to remove
     * @return the removed grade; null if does not exist
     */
    @Override
    public StudentGrade delete(StudentGrade sGrade) {
        StudentGrade studentGrade = results.remove(sGrade);
        /* If student doesn't exist, null is returned */
        return studentGrade;
    }

    /**
     * Clears all current results.
     */
    @Override
    public void clear() {
        results.clear();
    }
}
