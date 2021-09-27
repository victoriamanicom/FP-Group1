import { Card } from "react-bootstrap";
import Table from 'react-bootstrap/Table';
import "./VehicleReturn.css"

const VehicleReturn = ({vehicleData}) => {

    const ListVehicles = ({make, model, colour, licencePlate, regestrationDate}) => {
        return (
            <tr>
                <td>{make}</td>
                <td>{model}</td>
                <td>{colour}</td>
                <td>{licencePlate}</td>
                <td>{regestrationDate}</td>
            </tr>
        )
    }

    return (
        <Card className="vehicleReturn">
            <Card.Header className="vehicleReturnTitle">Vehicle Information</Card.Header>
            <Card.Body className="vehicleReturnBody">
                <Table className="vehicleTable">
                    <thead>
                        <tr>
                            <th>Make</th>
                            <th>Model</th>
                            <th>Colour</th>
                            <th>Licence Plate</th>
                            <th>Registration Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {vehicleData.map(vehicle =>
                        <ListVehicles key={vehicleData.licencePlate} {...vehicle} />
                        )}
                    </tbody>
                </Table>
            </Card.Body>
        </Card>
    )
}

export default VehicleReturn;