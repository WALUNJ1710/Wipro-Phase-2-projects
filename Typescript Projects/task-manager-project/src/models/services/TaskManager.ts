import { Task } from "../Task";

export class TaskManager {
    private tasks: Task[] = [];
    private taskIdCounter: number = 1;

    addTask(title: string, description: string): Task {
        const newTask = new Task(this.taskIdCounter++, title, description);
        this.tasks.push(newTask);
        return newTask;
    }

    getTasks(): Task[] {
        return this.tasks;
    }

    markTaskAsComplete(id: number): boolean {
        const task = this.tasks.find(task => task.id === id);
        if (task) {
            task.markComplete();
            return true;
        }
        return false;
    }
}
