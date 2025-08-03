import React from "react";
import EmployeeCard from "./EmployeeCard";

const EmployeesList = () => {
  const employees = [
    { id: 1, name: "Mayukh", role: "Backend Dev" },
    { id: 2, name: "Aniket", role: "Frontend Dev" },
    { id: 3, name: "Anurag", role: "Software Tester" },
  ];

  return (
    <div>
      <h2>Team List</h2>
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
};

export default EmployeesList;

