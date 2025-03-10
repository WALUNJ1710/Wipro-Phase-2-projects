"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Task = void 0;
class Task {
    constructor(id, title, description, isCompleted = false) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }
    markComplete() {
        this.isCompleted = true;
    }
}
exports.Task = Task;
