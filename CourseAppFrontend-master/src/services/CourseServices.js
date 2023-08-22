import axios from "axios";

const COURSE_API_BASE_URL = "http://localhost:9050/api/v1/courses";
const accessToken = localStorage.getItem('accessToken');
class CourseServices {
  saveCourse(course) {
    console.log(course,"course")
    return axios.post(COURSE_API_BASE_URL , course, {
        method: "POST",
        headers: {
          "Access-Control-Allow-Origin": "*",
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'Authorization': `Bearer ${accessToken}`
        },
        body: JSON.stringify(course),
       
      })
  }

  saveUserData(userData) {
    console.log(userData,"UserData")
    return axios.post("http://localhost:9050/auth/signup-user", userData, {
        method: "POST",
        headers: {
          "Access-Control-Allow-Origin": "*",
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        },
        body: JSON.stringify(userData),
      })
  }

  loginUser(data) {
    console.log(data,"data")
    return axios.post("http://localhost:9050/auth/login", data, {
        method: "POST",
        headers: {
          "Access-Control-Allow-Origin": "*",
          'Content-Type': 'application/json',
          'Accept': 'application/json'
        },
        body: JSON.stringify(data),
      })
  }

  getCourse() {
    return axios.get(COURSE_API_BASE_URL , {
        method: "GET",
        headers: {
          "Access-Control-Allow-Origin": "*",
          'Content-Type': 'application/json',
          'Accept': 'application/json',
          'Authorization': `Bearer ${accessToken}`
        },
      
      })
  
  }

  deleteCourse(id) {
    return axios.delete(COURSE_API_BASE_URL + "/" + id);
  }

  getCourseById(id) {
    return axios.get(COURSE_API_BASE_URL + "/" + id);
  }

  updateCourse(course, id) {
    return axios.put(COURSE_API_BASE_URL + "/" + id, course);
  }
}

export default new CourseServices();
