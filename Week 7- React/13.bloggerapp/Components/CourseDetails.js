
import React from "react";

const CourseDetails = ({ courses }) => {
  return (
    <div className="section">
      <h1>Course Details</h1>
      {courses.map((course, index) => (
        <div key={index}>
          <h3>{course.cname}</h3>
          <h4>{course.date}</h4>
        </div>
      ))}
    </div>
  );
};

export default CourseDetails;