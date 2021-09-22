import './SearchBar.css';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import FloatingLabel from 'react-bootstrap/FloatingLabel';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';

const SearchBar = ({handleSearch, handleReset}) => {

    return (
        <>
            <Form id="searchBarForm" onSubmit={handleSearch}>
                <Row>
                    <Col >
                        <FloatingLabel controlId="floatingForenames" label="Forenames">
                            <Form.Control type="text" name="searchForenames" placeholder="Forename"/>
                        </FloatingLabel>
                    </Col>
                    <Col >
                        <FloatingLabel controlId="floatingSurname" label="Surname">
                            <Form.Control type="text" name="searchSurname" placeholder="Surname"/>
                        </FloatingLabel>
                    </Col>
                    <Col>
                        <FloatingLabel controlId="floatingGender" label="Gender">
                            <Form.Select>
                                <option value="Unknown"></option>
                                <option value="Female">Female</option>
                                <option value="Male">Male</option>
                            </Form.Select>
                        </FloatingLabel>
                    </Col>
                    <Col xs={2} id="buttonColumn">
                        <Button id="searchButton" >Search</Button>
                        <br />
                        <Button id="resetButton" >Reset</Button>
                    </Col>
                    
                </Row>
                
            </Form>
        </>
    )

}

export default SearchBar;