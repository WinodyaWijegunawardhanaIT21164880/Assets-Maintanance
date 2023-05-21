import XLSX from 'xlsx/dist/xlsx.full.min.js';


const generateExcelReport = () => {
  const data = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
  const ws = XLSX.utils.aoa_to_sheet(data);
  const wb = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(wb, ws, "Sheet1");
  XLSX.writeFile(wb, "report.xlsx");
};

export default generateExcelReport;