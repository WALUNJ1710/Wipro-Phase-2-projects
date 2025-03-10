"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.TaskManager = void 0;
const Task_1 = require("../Task");
class TaskManager {
    constructor() {
        this.tasks = [];
        this.taskIdCounter = 1;
    }
    addTask(title, description) {
        const newTask = new Task_1.Task(this.taskIdCounter++, title, description);
        this.tasks.push(newTask);
        return newTask;
    }
    getTasks() {
        return this.tasks;
    }
    markTaskAsComplete(id) {
        const task = this.tasks.find(task => task.id === id);
        if (task) {
            task.markComplete();
            return true;
        }
        return false;
    }
}
exports.TaskManager = TaskManager;
//# sourceMappingURL=TaskManager.js.map