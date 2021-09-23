import { Card } from "react-bootstrap";
import Table from 'react-bootstrap/Table';
import "./VehicleReturn.css"

const VehicleReturn = () => {

    const vehicleData = [
        {
            make: "Ford",
            model: "T",
            colour: "yellow",
            vehicleRegistration: "YUS7",
            dateRegistration: "9842574"
        },{
            make: "Tesla",
            model: "S",
            colour: "Silver",
            vehicleRegistration: "H4H469",
            dateRegistration: "976863"
        }
    ]

    const ListVehicles = ({make, model, colour, vehicleRegistration, dateRegistration}) => {
        return (
            <tr>
                <td>{make}</td>
                <td>{model}</td>
                <td>{colour}</td>
                <td>{vehicleRegistration}</td>
                <td>{dateRegistration}</td>
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
                        <ListVehicles key={vehicleData.vehicleRegistration} {...vehicle} />
                        )}
                    </tbody>
                </Table>
            </Card.Body>
        </Card>
    )
}

export default VehicleReturn;