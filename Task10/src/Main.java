import java.util.ArrayList;
import java.util.List;

// Класс для управления сценариями
class ScriptManager {
    private List<String> scripts = new ArrayList<>();

    public void addScript(String script) {
        scripts.add(script);
    }

    public String selectScript(int index) {
        if (index >= 0 && index < scripts.size()) {
            return scripts.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid script index");
        }
    }
}

// Класс для управления актерами
class ActorManager {
    private List<String> actors = new ArrayList<>();

    public void hireActor(String actor) {
        actors.add(actor);
    }

    public List<String> getActors() {
        return actors;
    }
}

// Класс для управления съемками
class ShootingManager {
    public void startShooting(String script, List<String> actors) {
        System.out.println("Starting shooting for script: " + script);
        System.out.println("Actors: " + actors);
    }

    public void stopShooting() {
        System.out.println("Shooting stopped");
    }
}

// Фасад для системы управления киностудией
class MovieStudioFacade {
    private ScriptManager scriptManager;
    private ActorManager actorManager;
    private ShootingManager shootingManager;

    public MovieStudioFacade() {
        this.scriptManager = new ScriptManager();
        this.actorManager = new ActorManager();
        this.shootingManager = new ShootingManager();
    }

    public void addScript(String script) {
        scriptManager.addScript(script);
    }

    public void hireActor(String actor) {
        actorManager.hireActor(actor);
    }

    public void startShooting(int scriptIndex) {
        String script = scriptManager.selectScript(scriptIndex);
        List<String> actors = actorManager.getActors();
        shootingManager.startShooting(script, actors);
    }

    public void stopShooting() {
        shootingManager.stopShooting();
    }
}

// Основной класс для демонстрации
public class Main {
    public static void main(String[] args) {
        MovieStudioFacade facade = new MovieStudioFacade();

        facade.addScript("Script 1");
        facade.addScript("Script 2");

        facade.hireActor("Actor 1");
        facade.hireActor("Actor 2");

        facade.startShooting(0);

        facade.stopShooting();
    }
}
