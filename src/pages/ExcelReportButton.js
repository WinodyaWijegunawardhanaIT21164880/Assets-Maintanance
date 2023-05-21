import React from 'react';
import generateExcelReport from './ExcelReport';

const ReportButton = () => {
  return (
    <button onClick={generateExcelReport}>Generate Report</button>
  );
};

export default ReportButton;
