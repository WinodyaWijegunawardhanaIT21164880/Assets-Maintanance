import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import { Form } from 'react-bootstrap';
import InputGroup from 'react-bootstrap/InputGroup';
import 'bootstrap/dist/css/bootstrap.min.css';
import { data } from './pages/data.js';
import NavBar from './layout/NavBar';
import Footer from './layout/Footer';
import ReportButton from './pages/ExcelReportButton';
import AssetForm from './Features/ReportGenaration/Assets/AssetsForms';
import AssetsDisplay from './Features/AssetDisplay/AssetsDisplay';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

 
  


function App() {
   const [contacts, setContacts] = useState(data);
  const [search, setSearch] = useState('');

 

  return (
    <div className="App">
      <div>{<NavBar/>}</div>
      <Router>
	<div>
        <Routes>
          <Route exact path="/" element={<AssetsDisplay/>}/>
          <Route exact path="/Asset-Form" element={<AssetForm/>}/>
         
          {/* <Route path="*" element={<NotFound/>}/> */}
        </Routes>

</div>
    </Router>
      <Footer/>
    </div>
    
   
  );
}

export default App;
