export default function BookTicket() {
  return (
    <div>
      <h3>Book Your Flight</h3>
      <form>
        <label>Flight Number: </label>
        <input type="text" placeholder="Enter flight number" />
        <br />
        <label>Passenger Name: </label>
        <input type="text" placeholder="Enter your name" />
        <br />
        <button type="submit">Book Now</button>
      </form>
    </div>
  );
}