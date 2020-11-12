import Vue from 'vue'

import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Calendar from "../views/Calendar";
import Grades from "../views/Grades";
import Subjects from "../views/Subjects";
import Account from "../views/Account";
import Subject from "../components/Subject";
import SubjectInfo from "../views/SubjectInfo";
import Secured from "../components/Secured";
import SignIn from "../components/SignIn";
import NotFound from "../components/NotFound";

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
  {
    path: '/subjectInfo/:id',
    name: 'SubjectInfo',
    component: SubjectInfo
  },

  {
    path: '/secured',
    name: 'Secured',
    component: Secured,
  },
  {
    path: '/signIn',
    name: 'signIn',
    component: SignIn,
    meta: { loginPage: true, nonRequiresAuth: true },
  },
  {
    path: '*',
    component: NotFound,
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  const requiresAuth = !to.matched.some((record) => record.meta.nonRequiresAuth);
  const isLoginPage = to.matched.some((record) => record.meta.loginPage);
  const isAuthenticated = localStorage.getItem('auth');
  if (requiresAuth && !isAuthenticated) {
    next('/signIn');
  } else if (isLoginPage && isAuthenticated) {
    router.push('/home');
  }
  next();
})

export default router
