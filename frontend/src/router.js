import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Login from './views/Login.vue';
import Register from './views/Register.vue';

import Calendar from "./views/Calendar";
import Grades from "./views/Grades";
import Subjects from "./views/Subjects";
import Account from "./views/Account";
import Subject from "./components/Subject";
import SubjectInfo from "./views/SubjectInfo";

Vue.use(Router);

export const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
    },
    {
      path: '/register',
      component: Register
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
      path: '/profile',
      name: 'profile',
      // lazy-loaded
      component: () => import('./views/Profile.vue')
    },
    {
      path: '/admin',
      name: 'admin',
      // lazy-loaded
      component: () => import('./views/BoardAdmin.vue')
    },
    {
      path: '/mod',
      name: 'moderator',
      // lazy-loaded
      component: () => import('./views/BoardModerator.vue')
    },
    {
      path: '/user',
      name: 'user',
      // lazy-loaded
      component: () => import('./views/BoardUser.vue')
    }
  ]
});


// router.beforeEach((to, from, next) => {
//   const publicPages = ['/login', '/register', 'home'];
//   const authRequired = !publicPages.includes(to.path);
//   const loggedIn = localStorage.getItem('user');

//   // trying to access a restricted page + not logged in
//   // redirect to login page
//   if (authRequired && !loggedIn) {
//     next('/login');
    
//   } 
//   else if (authRequired && loggedIn){
//     router.push('/home');
//   }
  
//   else {
//     next();
//   }
// });


// router.beforeEach((to, from, next) => {
//   const requiresAuth = !to.matched.some((record) => record.meta.nonRequiresAuth);
//   const isLoginPage = to.matched.some((record) => record.meta.loginPage);
//   const loggedIn = localStorage.getItem('user');

//   // trying to access a restricted page + not logged in
//   // redirect to login page
//   if (requiresAuth && !loggedIn) {
//     next('/login');
    
//   } 
//   else if (isLoginPage && loggedIn){
//     router.push('/home');
//   }
  
//   else {
//     next();
//   }
// });

// router.beforeEach((to, from, next) => {
//   const loggedIn = localStorage.getItem('user');
//   if (to.name !== 'Login' && !loggedIn) next({ name: 'Login' })
//   else next()
// })


router.beforeEach((to, from, next) => {
  // if (to.matched.some(record => record.meta.requiresAuth)) {
  // this route requires auth, check if logged in
  // if not, redirect to login page.
  if (to.path !== "/login")
    if (localStorage.getItem("user") == null) {
      next({
        path: "/login"
      });
    } else {
      next();
    }
  next(); // make sure to always call next()!
});

export default router;
