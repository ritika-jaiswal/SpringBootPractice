import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import CourseServices from "../services/CourseServices";
import Courses from "./Courses";
import Navbar from "./Navbar";

const CourseList = () => {
  const navigate = useNavigate();

  const [loading, setLoading] = useState(true);
  const [course,setCourse] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await CourseServices.getCourse();
      setCourse(response.data);
      console.log(response)
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  const deleteCourse = (e, id) => {
    e.preventDefault();
   CourseServices.deleteCourse(id).then((res) => {
      if (course) {
      setCourse((prevElement) => {
          return prevElement.filter((course) => course.id !== id);
        });
      }
    });
  };

  return (
    <>
     <Navbar/>
 
    <div className="container mx-auto my-8">
     
      <div className="h-12">
        <button
          onClick={() => navigate("/addCourse")}
          className="rounded bg-slate-600 text-white px-6 py-2 ml-2 font-semibold">
          Add Course
        </button>
      </div>
      <div className="flex shadow border-b">
        <table className="w-full">
          <thead className="bg-gray-50 ">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Course Id
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Course Title
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Course Description
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {console.log(course)}
              {course&&course.map((course) => (
                <Courses
                  course={course}
                  deleteCourse={deleteCourse}
                  key={course.id}></Courses>
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
    </>
  );
};

export default CourseList;
