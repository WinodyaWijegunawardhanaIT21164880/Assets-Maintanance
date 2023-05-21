import React, { useState } from 'react';
import ReportButton from "../../pages/ExcelReportButton";
import { data } from "../../pages/data";
import Table from 'react-bootstrap/Table';
import { Form } from 'react-bootstrap';
import InputGroup from 'react-bootstrap/InputGroup';
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { Link } from 'react-router-dom';

export default function AssetsDisplay(){
    const [contacts, setContacts] = useState(data);
  const [search, setSearch] = useState('');

    return(<React.Fragment>
        <div className="App">
      
      <div>
      <h1> Report Generator</h1>
      <ReportButton />
    </div>
    <div/> 
    
      <Container>
        <h1 className='text-center mt-4'>Contact Keeper</h1>
        <Form>
          <InputGroup className='my-3'>


            {/* onChange for search */}
            <Form.Control
              onChange={(e) => setSearch(e.target.value)}
              placeholder='Search Assets By Assets Name'
            />
          </InputGroup>
          <Link to="/Asset-Form">
      <button className="gradient-button">Add New Assets</button>
    </Link>
        </Form>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>AssetID</th>
              <th>AssetName</th>
              <th>Quantity</th>
              <th>Availability</th>
              <th>AssetType</th>
              <th>Update</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>

            {contacts
              .filter((item) => {
                return search.toLowerCase() === ''
                  ? item
                  : item.AssetName.toLowerCase().includes(search);
              })
              .map((item, index) => (
                <tr key={index}>
                  <td>{item.AssetID}</td>
                  <td>{item.AssetName}</td>
                  <td>{item.Quantity}</td>
                  <td>{item.Availability}</td>
                  <td>{item.AssetType}</td>
                  <td><button class="update-button">Update</button></td>
                  <td><button class="delete-button">Delete</button></td>

                  

                </tr>
              ))}

          </tbody>
        </Table>
        
      </Container>
      
    </div>
    </React.Fragment>)
};