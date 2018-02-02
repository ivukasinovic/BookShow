import {Component, Input, OnInit} from '@angular/core';
import {Bid} from '../../models/prop';
import {PropService} from '../prop.service';

@Component({
  selector: 'app-bid-list',
  templateUrl: './bid-list.component.html',
  styleUrls: ['./bid-list.component.css']
})
export class BidListComponent implements OnInit {

  @Input() bids: Bid[];
  constructor(private propService: PropService) { }

  ngOnInit() {
  }

}
