import Vue from 'vue'

import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Calendar from "../views/Calendar";
import Grades from "../views/Grades";
import Subjects from "../views/Subjects";
import Account from "../views/Account";
import Subject from "../components/Subject";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/grades',
    name: 'Grades',
    component: Grades
  },
  {
    path: '/calendar',
    name: 'Calendar',
    component: Calendar
  },
  {
    path: '/subjects',
    name: 'Subjects',
    component: Subjects
  },
  {
    path: '/account',
    name: 'Account',
    component: Account
  },
  {
    path: '/subject',
    name: 'Subject',
    component: Subject
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
