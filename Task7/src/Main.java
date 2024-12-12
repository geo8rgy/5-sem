import java.util.ArrayList;
import java.util.List;

// Класс Project
class Project {
    private String name;
    private String description;
    private List<String> participants;
    private String deadline;

    private Project(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.participants = builder.participants;
        this.deadline = builder.deadline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", participants=" + participants +
                ", deadline='" + deadline + '\'' +
                '}';
    }

    // Статический внутренний класс Builder
    public static class Builder {
        private String name;
        private String description;
        private List<String> participants = new ArrayList<>();
        private String deadline;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder addParticipant(String participant) {
            this.participants.add(participant);
            return this;
        }

        public Builder setDeadline(String deadline) {
            this.deadline = deadline;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        Project project = new Project.Builder()
                .setName("New Project")
                .setDescription("This is a new project description")
                .addParticipant("Alice")
                .addParticipant("Bob")
                .setDeadline("2023-12-31")
                .build();

        System.out.println(project);
    }
}
