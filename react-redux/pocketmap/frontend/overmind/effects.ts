export { default as http } from "axios";
import axios from "axios";

const server = "http://localhost:8080";

export class API {
  private app;
  private server;
  private request;

  constructor(server, request) {
    this.server = server;
    this.request = request;
  }

  // ? Maps the rooms data to an array of values.
  updateRooms() {
    const rooms = this.request.get(`${this.server}/rooms`).then((response) => {
      const rooms = response.data._embedded.rooms.map((r: { name: any }) => {
        return {
          name: r.name,
          // TODO more rooms data as desired.
        };
      });
      return rooms;
    });
    console.log(rooms);
    return rooms;
  }
}

export const api = new API(server, axios);
