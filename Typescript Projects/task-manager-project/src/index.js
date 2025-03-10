"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const TaskManager_1 = require("./models/services/TaskManager");
const taskManager = new TaskManager_1.TaskManager();
//Adding Tasks
const task1 = taskManager.addTask("Finish Typescript Project", "Complete the Task Management System");
const task2 = taskManager.addTask("Review Tasks", "check pull requests on Github");
console.log("All Tasks:", taskManager.getTasks());
//Marking a Task as Complete
const isCompleted = taskManager.markTaskAsComplete(1);
console.log(isCompleted ? "Test marked as complete!" : "Task not found!");
console.log("Updated Tasks:", taskManager.getTasks());
