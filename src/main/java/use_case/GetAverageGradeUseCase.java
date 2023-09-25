package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        // TODO: Get average grade for all students in your team.

        String[] membersList = gradeDB.getMyTeam().getMembers();
        int totalMembers = 0;
        float sumGrade = 0.0f;

        for (String member : membersList) {
            Grade collectedGrade = gradeDB.getGrade(member, course);
            sumGrade += collectedGrade.getGrade();
            totalMembers += 1;
        }

        return sumGrade / totalMembers;
    }
}