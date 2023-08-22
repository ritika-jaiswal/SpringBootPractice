import logo from "./logo.svg";
import "./App.css";
import Navbar from "./components/Navbar";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import CourseList from "./components/CourseList";
import AddCourse from "./components/AddCourse";
import UpdateCourse from "./components/UpdateCourse";
import Registration from "./components/Registration";
import Login from "./components/Login";
import Authentication from "./components/Authentication";

function App() {
  return (
    <>
      <BrowserRouter>
        {/* <Navbar /> */}

        {/* <Routes>
          <Route index element={<CourseList />} />
          <Route path="/" element={<Registration/>}> </Route>
           <Route path="/" element={<Login />}></Route>
          <Route path="/courseList" element={<CourseList />} />
          <Route path="/addCourse" element={<AddCourse />} />
          <Route path="/editCourse/:id" element={<UpdateCourse />} />
        </Routes> */}

        <Routes>
          <Route index element={<Authentication />} />
          <Route path="/" element={<Registration/>}> </Route>
           <Route path="/login" element={<Login />}></Route>
          <Route path="/courseList" element={<CourseList />} />
          <Route path="/addCourse" element={<AddCourse />} />
          <Route path="/editCourse/:id" element={<UpdateCourse />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
