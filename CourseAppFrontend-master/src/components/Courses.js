import React from "react";
import { useNavigate } from "react-router-dom";
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';

const Courses = ({ course, deleteCourse }) => {
  const navigate = useNavigate();
  const editCourse = (e, id) => {
    e.preventDefault();
    navigate(`/editCourse/${id}`);
  };

  return (
    <tr key={course.id}>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{course.id}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{course.title}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{course.description}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
        <EditIcon onClick={(e, id) => editCourse(e, course.id)} style={{width: "1.2rem", marginRight: "1.5rem"}}/>
        {/* //   onClick={(e, id) => editCourse(e, course.id)}
        //   className="text-indigo-600 hover:text-indigo-800 px-4 hover:cursor-pointer">
        
        // </EditIcon> */}
        {/* <a
          onClick={(e, id) => deleteCourse(e, course.id)}
          className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer">
          Delete
        </a> */}
        <DeleteIcon  onClick={(e, id) => deleteCourse(e, course.id)} style={{width: "1.2rem", px:"1rem"}}/>
      </td>
    </tr>
  );
};

export default Courses;
